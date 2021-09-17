package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQMessageProperties;

final class T4Caqdq extends T4CTTIfun {
   T4CTTIaqm aqm;
   T4Ctoh toh;
   private String queueName;
   private AQDequeueOptions dequeueOptions = null;
   private byte[] payloadToid = null;
   private byte[] queueNameBytes = null;
   private byte[] consumerNameBytes = null;
   private byte[] correlationBytes = null;
   private byte[] conditionBytes = null;
   private int nbExtensions = 0;
   private byte[][] extensionTextValues = (byte[][])null;
   private byte[][] extensionBinaryValues = (byte[][])null;
   private int[] extensionKeywords = null;
   private byte[] payload = null;
   private boolean hasAMessageBeenDequeued = false;
   private byte[] dequeuedMessageId = null;
   private boolean isRawQueue = false;
   private AQMessagePropertiesI properties = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4Caqdq(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)122);
      this.toh = new T4Ctoh();
      this.aqm = new T4CTTIaqm(this.connection, this.toh);
   }

   void doOAQDQ(String var1, AQDequeueOptions var2, byte[] var3, boolean var4, AQMessagePropertiesI var5) throws SQLException, IOException {
      this.queueName = var1;
      this.dequeueOptions = var2;
      this.payloadToid = var3;
      this.isRawQueue = var4;
      this.properties = var5;
      if (this.queueName != null && this.queueName.length() != 0) {
         this.queueNameBytes = this.meg.conv.StringToCharBytes(this.queueName);
      } else {
         this.queueNameBytes = null;
      }

      String var6 = this.dequeueOptions.getConsumerName();
      if (var6 != null && var6.length() > 0) {
         this.consumerNameBytes = this.meg.conv.StringToCharBytes(var6);
      } else {
         this.consumerNameBytes = null;
      }

      String var7 = this.dequeueOptions.getCorrelation();
      if (var7 != null && var7.length() != 0) {
         this.correlationBytes = this.meg.conv.StringToCharBytes(var7);
      } else {
         this.correlationBytes = null;
      }

      String var8 = this.dequeueOptions.getCondition();
      if (var8 != null && var8.length() > 0) {
         this.conditionBytes = this.meg.conv.StringToCharBytes(var8);
      } else {
         this.conditionBytes = null;
      }

      String var9 = this.dequeueOptions.getTransformation();
      if (var9 != null && var9.length() > 0) {
         this.nbExtensions = 1;
         this.extensionTextValues = new byte[this.nbExtensions][];
         this.extensionBinaryValues = new byte[this.nbExtensions][];
         this.extensionKeywords = new int[this.nbExtensions];
         this.extensionTextValues[0] = this.meg.conv.StringToCharBytes(var9);
         this.extensionBinaryValues[0] = null;
         this.extensionKeywords[0] = 196;
      } else {
         this.nbExtensions = 0;
      }

      this.hasAMessageBeenDequeued = false;
      this.dequeuedMessageId = null;
      this.payload = null;
      this.doRPC();
   }

   void marshal() throws IOException {
      if (this.queueNameBytes != null && this.queueNameBytes.length != 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.queueNameBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      if (this.consumerNameBytes != null && this.consumerNameBytes.length != 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.consumerNameBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalSB4(this.dequeueOptions.getDequeueMode().getCode());
      this.meg.marshalSB4(this.dequeueOptions.getNavigation().getCode());
      this.meg.marshalSB4(this.dequeueOptions.getVisibility().getCode());
      this.meg.marshalSB4(this.dequeueOptions.getWait());
      byte[] var1 = this.dequeueOptions.getDequeueMessageId();
      boolean var2 = false;
      if (var1 != null && var1.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(var1.length);
         var2 = true;
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      if (this.correlationBytes != null && this.correlationBytes.length != 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.correlationBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalPTR();
      this.meg.marshalSWORD(this.payloadToid.length);
      this.meg.marshalUB2(1);
      this.meg.marshalPTR();
      if (this.dequeueOptions.getRetrieveMessageId()) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(16);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      int var3 = 0;
      if (this.connection.autocommit) {
         var3 = 32;
      }

      if (this.dequeueOptions.getDeliveryFilter() == AQDequeueOptions.DeliveryFilter.BUFFERED) {
         var3 |= 2;
      } else if (this.dequeueOptions.getDeliveryFilter() == AQDequeueOptions.DeliveryFilter.PERSISTENT_OR_BUFFERED) {
         var3 |= 16;
      }

      this.meg.marshalUB4((long)var3);
      if (this.conditionBytes != null && this.conditionBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.conditionBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      if (this.nbExtensions > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.nbExtensions);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      if (this.queueNameBytes != null && this.queueNameBytes.length != 0) {
         this.meg.marshalCHR(this.queueNameBytes);
      }

      if (this.consumerNameBytes != null && this.consumerNameBytes.length != 0) {
         this.meg.marshalCHR(this.consumerNameBytes);
      }

      if (var2) {
         this.meg.marshalB1Array(var1);
      }

      if (this.correlationBytes != null && this.correlationBytes.length != 0) {
         this.meg.marshalCHR(this.correlationBytes);
      }

      this.meg.marshalB1Array(this.payloadToid);
      if (this.conditionBytes != null && this.conditionBytes.length > 0) {
         this.meg.marshalCHR(this.conditionBytes);
      }

      if (this.nbExtensions > 0) {
         this.meg.marshalKPDKV(this.extensionTextValues, this.extensionBinaryValues, this.extensionKeywords);
      }

   }

   byte[] getPayload() {
      return this.payload;
   }

   boolean hasAMessageBeenDequeued() {
      return this.hasAMessageBeenDequeued;
   }

   byte[] getDequeuedMessageId() {
      return this.dequeuedMessageId;
   }

   void readRPA() throws SQLException, IOException {
      this.hasAMessageBeenDequeued = true;
      int var1 = (int)this.meg.unmarshalUB4();
      if (var1 > 0) {
         this.aqm.initToDefaultValues();
         this.aqm.receive();
         this.properties.setPriority(this.aqm.aqmpri);
         this.properties.setDelay(this.aqm.aqmdel);
         this.properties.setExpiration(this.aqm.aqmexp);
         String var2;
         if (this.aqm.aqmcorBytes != null) {
            var2 = this.meg.conv.CharBytesToString(this.aqm.aqmcorBytes, this.aqm.aqmcorBytesLength, true);
            this.properties.setCorrelation(var2);
         }

         this.properties.setAttempts(this.aqm.aqmatt);
         if (this.aqm.aqmeqnBytes != null) {
            var2 = this.meg.conv.CharBytesToString(this.aqm.aqmeqnBytes, this.aqm.aqmeqnBytesLength, true);
            this.properties.setExceptionQueue(var2);
         }

         this.properties.setMessageState(AQMessageProperties.MessageState.getMessageState(this.aqm.aqmsta));
         this.properties.setEnqueueTime(this.aqm.aqmeqt.timestampValue());
         AQAgentI var7 = new AQAgentI();
         if (this.aqm.senderAgentName != null) {
            var7.setName(this.meg.conv.CharBytesToString(this.aqm.senderAgentName, this.aqm.senderAgentNameLength, true));
         }

         if (this.aqm.senderAgentAddress != null) {
            var7.setAddress(this.meg.conv.CharBytesToString(this.aqm.senderAgentAddress, this.aqm.senderAgentAddressLength, true));
         }

         var7.setProtocol(this.aqm.senderAgentProtocol);
         this.properties.setSender(var7);
         this.properties.setPreviousQueueMessageId(this.aqm.originalMsgId);
         this.properties.setDeliveryMode(AQMessageProperties.DeliveryMode.getDeliveryMode(this.aqm.aqmflg));
         if (this.aqm.aqmetiBytes != null) {
            String var3 = this.meg.conv.CharBytesToString(this.aqm.aqmetiBytes, this.aqm.aqmetiBytes.length, true);
            this.properties.setTransactionGroup(var3);
         }
      }

      int var8 = (int)this.meg.unmarshalUB4();
      this.toh.unmarshal(this.meg);
      int var9 = this.toh.imageLength;
      if (var9 > 0) {
         int var4 = var9;
         byte[] var5;
         int[] var6;
         if (this.isRawQueue) {
            if (var9 > 4) {
               var4 = var9 - 4;
            }

            var4 = Math.min(var4, this.dequeueOptions.getMaximumBufferLength());
            var5 = new byte[var4];
            var6 = new int[1];
            if (var9 > 4) {
               this.meg.unmarshalCLR(var5, 0L, var6, var5.length, 4);
            } else {
               this.meg.unmarshalCLR(var5, 0, var6, var5.length);
            }

            this.payload = var5;
         } else {
            var5 = new byte[var9];
            var6 = new int[1];
            this.meg.unmarshalCLR(var5, 0, var6, var5.length);
            this.payload = var5;
         }
      }

      if (this.dequeueOptions.getRetrieveMessageId()) {
         byte[] var10 = new byte[16];
         this.meg.unmarshalBuffer(var10, 0, 16);
         this.dequeuedMessageId = var10;
      }

   }

   void processError() throws SQLException {
      if (this.oer.retCode != 25228) {
         this.oer.processError();
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
