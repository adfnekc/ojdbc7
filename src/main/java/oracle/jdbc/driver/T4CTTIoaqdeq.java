package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSDequeueOptions;
import oracle.jdbc.internal.JMSMessageProperties;

public class T4CTTIoaqdeq extends T4CTTIfun {
   static final int AQTTC_DEQ_OPTS_DEFAULT = 0;
   static final int AQTTC_DEQ_OPTS_ON_COMMIT = 1;
   static final int AQTTC_DEQ_OPTS_IMMEDIATE = 2;
   static final int AQTTC_DEQ_OPTS_FOREVER = 4;
   static final int AQTTC_DEQ_OPTS_BROWSE = 8;
   static final int AQTTC_DEQ_OPTS_LOCKED = 16;
   static final int AQTTC_DEQ_OPTS_REMOVE = 32;
   static final int AQTTC_DEQ_OPTS_REMOVE_NO_DATA = 64;
   static final int AQTTC_DEQ_OPTS_BUFFERED = 128;
   static final int AQTTC_DEQ_OPT_PERS_BUFF = 256;
   private T4Ctoh toh = null;
   private T4CTTIaqm aqm = null;
   private T4CTTIaqjms aqjms = null;
   private byte[] payloadToid = null;
   private byte[] payload = null;
   private byte[] dequeuedMessageId = null;
   private byte[] queueNameBytes = null;
   private byte[] consumerNameBytes = null;
   private byte[] correlationBytes = null;
   private byte[] conditionBytes = null;
   private byte[] jmsPropertyBytes = null;
   private boolean hasAMessageBeenDequeued = false;
   private String queueName;
   private JMSDequeueOptions dequeueOptions = null;
   private AQMessagePropertiesI aqMessageProperties = null;
   private JMSMessagePropertiesI jmsMessageProperties = null;

   T4CTTIoaqdeq(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)185);
      this.toh = new T4Ctoh();
      this.aqm = new T4CTTIaqm(this.connection, this.toh);
   }

   public void doJMSDeq(String var1, JMSDequeueOptions var2, byte[] var3, AQMessagePropertiesI var4, JMSMessagePropertiesI var5) throws SQLException, IOException {
      this.queueName = var1;
      this.dequeueOptions = var2;
      this.payloadToid = var3;
      this.aqMessageProperties = var4;
      this.jmsMessageProperties = var5;
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

      if (this.consumerNameBytes != null && this.consumerNameBytes.length != 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.consumerNameBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

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

      boolean var3 = false;
      byte var4;
      if (this.connection.autocommit) {
         var4 = 2;
      } else {
         var4 = 1;
      }

      int var5 = var4 | this.dequeueOptions.getDeliveryMode().getCode();
      var5 |= this.dequeueOptions.getDequeueMode().getCode();
      var5 |= this.dequeueOptions.getVisibility().getCode();
      if (this.dequeueOptions.getWait() == 4) {
         var5 |= 4;
         this.meg.marshalUB4((long)var5);
         this.meg.marshalSB4(-1);
      } else {
         this.meg.marshalUB4((long)var5);
         this.meg.marshalSB4(this.dequeueOptions.getWait());
      }

      if (this.conditionBytes != null && this.conditionBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.conditionBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      if (this.payloadToid != null && this.payloadToid.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.payloadToid.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalUB2(1);
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalNULLPTR();
      if (this.dequeueOptions.isRetrieveMessageId()) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(16);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalUB4(0L);
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalPTR();
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

      if (this.conditionBytes != null && this.conditionBytes.length > 0) {
         this.meg.marshalCHR(this.conditionBytes);
      }

      this.meg.marshalB1Array(this.payloadToid);
   }

   void readRPA() throws SQLException, IOException {
      this.hasAMessageBeenDequeued = true;
      int var1 = (int)this.meg.unmarshalUB4();
      if (var1 > 0) {
         this.aqm.initToDefaultValues();
         this.aqm.receive();
         this.aqMessageProperties.setPriority(this.aqm.aqmpri);
         this.aqMessageProperties.setDelay(this.aqm.aqmdel);
         this.aqMessageProperties.setExpiration(this.aqm.aqmexp);
         String var2;
         if (this.aqm.aqmcorBytes != null) {
            var2 = this.meg.conv.CharBytesToString(this.aqm.aqmcorBytes, this.aqm.aqmcorBytesLength, true);
            this.aqMessageProperties.setCorrelation(var2);
         }

         this.aqMessageProperties.setAttempts(this.aqm.aqmatt);
         if (this.aqm.aqmeqnBytes != null) {
            var2 = this.meg.conv.CharBytesToString(this.aqm.aqmeqnBytes, this.aqm.aqmeqnBytesLength, true);
            this.aqMessageProperties.setExceptionQueue(var2);
         }

         this.aqMessageProperties.setMessageState(AQMessageProperties.MessageState.getMessageState(this.aqm.aqmsta));
         if (this.aqm.aqmeqt != null) {
            this.aqMessageProperties.setEnqueueTime(this.aqm.aqmeqt.timestampValue());
         }

         AQAgentI var6 = new AQAgentI();
         if (this.aqm.senderAgentName != null) {
            var6.setName(this.meg.conv.CharBytesToString(this.aqm.senderAgentName, this.aqm.senderAgentNameLength, true));
         }

         if (this.aqm.senderAgentAddress != null) {
            var6.setAddress(this.meg.conv.CharBytesToString(this.aqm.senderAgentAddress, this.aqm.senderAgentAddressLength, true));
         }

         var6.setProtocol(this.aqm.senderAgentProtocol);
         this.aqMessageProperties.setSender(var6);
         this.aqMessageProperties.setPreviousQueueMessageId(this.aqm.originalMsgId);
         this.aqMessageProperties.setDeliveryMode(AQMessageProperties.DeliveryMode.getDeliveryMode(this.aqm.aqmflg));
         if (this.aqm.aqmetiBytes != null) {
            String var3 = this.meg.conv.CharBytesToString(this.aqm.aqmetiBytes, this.aqm.aqmetiBytes.length, true);
            this.aqMessageProperties.setTransactionGroup(var3);
         }
      }

      if (this.dequeueOptions.isRetrieveMessageId()) {
         byte[] var7 = new byte[16];
         this.meg.unmarshalBuffer(var7, 0, 16);
         this.dequeuedMessageId = var7;
      }

      int var8 = (int)this.meg.unmarshalUB4();
      if (var8 > 0) {
         this.payload = new byte[var8];
         this.meg.unmarshalBuffer(this.payload, 0, this.payload.length);
      }

      int var9 = (int)this.meg.unmarshalUB4();
      if (var9 > 0) {
         this.aqjms = new T4CTTIaqjms(this.connection);
         this.aqjms.receive();
         String var4 = this.meg.conv.CharBytesToString(this.aqjms.aqjmshdrprop, this.aqjms.aqjmshdrprop.length, true);
         this.jmsMessageProperties.setHeaderProperties(var4);
         String var5 = this.meg.conv.CharBytesToString(this.aqjms.aqjmsuserprop, this.aqjms.aqjmsuserprop.length, true);
         this.jmsMessageProperties.setUserProperties(var5);
         this.jmsMessageProperties.setJMSMessageType(JMSMessageProperties.JMSMessageType.getJMSMessageType(this.aqjms.aqjmsflags));
      }

   }

   public boolean isHasAMessageBeenDequeued() {
      return this.hasAMessageBeenDequeued;
   }

   public byte[] getPayload() {
      return this.payload;
   }

   public byte[] getDequeuedMessageId() {
      return this.dequeuedMessageId;
   }

   public AQMessagePropertiesI getAQMessageProperties() {
      return this.aqMessageProperties;
   }

   public JMSMessagePropertiesI getJMSMessageProperties() {
      return this.jmsMessageProperties;
   }
}
