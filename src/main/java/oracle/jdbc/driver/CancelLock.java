package oracle.jdbc.driver;

class CancelLock {
   private CancelLock.State state;

   CancelLock() {
      this.state = CancelLock.State.IDLE;
   }

   boolean isIdle() {
      return this.state == CancelLock.State.IDLE;
   }

   synchronized void enterExecuting() {
      assert this.state == CancelLock.State.IDLE;

      this.state = CancelLock.State.EXECUTING;
   }

   synchronized void exitExecuting() {
      while(this.state != CancelLock.State.EXECUTING) {
         assert this.state == CancelLock.State.CANCELING;

         try {
            this.wait();
         } catch (InterruptedException var2) {
         }
      }

      this.state = CancelLock.State.IDLE;
   }

   synchronized boolean enterCanceling() {
      if (this.state == CancelLock.State.EXECUTING) {
         this.state = CancelLock.State.CANCELING;
         return true;
      } else {
         return false;
      }
   }

   synchronized void exitCanceling() {
      assert this.state == CancelLock.State.CANCELING;

      this.state = CancelLock.State.EXECUTING;
      this.notify();
   }

   private static enum State {
      IDLE,
      EXECUTING,
      CANCELING;
   }
}
