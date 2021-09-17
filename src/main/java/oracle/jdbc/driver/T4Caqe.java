package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.aq.AQEnqueueOptions;

final class T4Caqe extends T4CTTIfun {
   static final int KPD_AQ_BUFMSG = 2;
   static final int KPD_AQ_EITHER = 16;
   static final int OCI_COMMIT_ON_SUCCESS = 32;
   static final int ATTR_TRANSFORMATION = 196;
   T4CTTIaqm aqm;
   T4Ctoh toh;
   private byte[] queueNameBytes = null;
   private AQEnqueueOptions enqueueOptions = null;
   private AQMessagePropertiesI messageProperties = null;
   private byte[] messageData = null;
   private byte[] messageOid = null;
   private boolean isRawQueue = false;
   private int nbExtensions = 0;
   private byte[][] extensionTextValues = (byte[][])null;
   private byte[][] extensionBinaryValues = (byte[][])null;
   private int[] extensionKeywords = null;
   private AQAgentI[] attrRecipientList = null;
   private byte[][] recipientTextValues = (byte[][])null;
   private byte[][] recipientBinaryValues = (byte[][])null;
   private int[] recipientKeywords = null;
   private byte[] aqmcorBytes;
   private byte[] aqmeqnBytes;
   private boolean retrieveMessageId = false;
   private byte[] outMsgid = null;
   private byte[] senderAgentName = null;
   private byte[] senderAgentAddress = null;
   private byte senderAgentProtocol = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4Caqe(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)121);
      this.toh = new T4Ctoh();
      this.aqm = new T4CTTIaqm(this.connection, this.toh);
   }

   void doOAQEQ(String var1, AQEnqueueOptions var2, AQMessagePropertiesI var3, byte[] var4, byte[] var5, boolean var6) throws SQLException, IOException {
      this.enqueueOptions = var2;
      this.messageProperties = var3;
      String var7 = this.messageProperties.getCorrelation();
      if (var7 != null && var7.length() != 0) {
         this.aqmcorBytes = this.meg.conv.StringToCharBytes(var7);
      } else {
         this.aqmcorBytes = null;
      }

      String var8 = this.messageProperties.getExceptionQueue();
      if (var8 != null && var8.length() != 0) {
         this.aqmeqnBytes = this.meg.conv.StringToCharBytes(var8);
      } else {
         this.aqmeqnBytes = null;
      }

      AQAgentI var9 = (AQAgentI)this.messageProperties.getSender();
      if (var9 != null) {
         if (var9.getName() != null) {
            this.senderAgentName = this.meg.conv.StringToCharBytes(var9.getName());
         } else {
            this.senderAgentName = null;
         }

         if (var9.getAddress() != null) {
            this.senderAgentAddress = this.meg.conv.StringToCharBytes(var9.getAddress());
         } else {
            this.senderAgentAddress = null;
         }

         this.senderAgentProtocol = (byte)var9.getProtocol();
      } else {
         this.senderAgentName = null;
         this.senderAgentAddress = null;
         this.senderAgentProtocol = 0;
      }

      this.messageData = var4;
      this.messageOid = var5;
      this.isRawQueue = var6;
      if (var1 != null && var1.length() != 0) {
         this.queueNameBytes = this.meg.conv.StringToCharBytes(var1);
      } else {
         this.queueNameBytes = null;
      }

      this.attrRecipientList = (AQAgentI[])((AQAgentI[])this.messageProperties.getRecipientList());
      if (this.attrRecipientList != null && this.attrRecipientList.length > 0) {
         this.recipientTextValues = new byte[this.attrRecipientList.length * 3][];
         this.recipientBinaryValues = new byte[this.attrRecipientList.length * 3][];
         this.recipientKeywords = new int[this.attrRecipientList.length * 3];

         for(int var10 = 0; var10 < this.attrRecipientList.length; ++var10) {
            if (this.attrRecipientList[var10].getName() != null) {
               this.recipientTextValues[3 * var10] = this.meg.conv.StringToCharBytes(this.attrRecipientList[var10].getName());
            }

            if (this.attrRecipientList[var10].getAddress() != null) {
               this.recipientTextValues[3 * var10 + 1] = this.meg.conv.StringToCharBytes(this.attrRecipientList[var10].getAddress());
            }

            this.recipientBinaryValues[3 * var10 + 2] = new byte[1];
            this.recipientBinaryValues[3 * var10 + 2][0] = (byte)this.attrRecipientList[var10].getProtocol();
            this.recipientKeywords[3 * var10] = 3 * var10;
            this.recipientKeywords[3 * var10 + 1] = 3 * var10 + 1;
            this.recipientKeywords[3 * var10 + 2] = 3 * var10 + 2;
         }
      }

      String var11 = this.enqueueOptions.getTransformation();
      if (var11 != null && var11.length() > 0) {
         this.nbExtensions = 1;
         this.extensionTextValues = new byte[this.nbExtensions][];
         this.extensionBinaryValues = new byte[this.nbExtensions][];
         this.extensionKeywords = new int[this.nbExtensions];
         this.extensionTextValues[0] = this.meg.conv.StringToCharBytes(var11);
         this.extensionBinaryValues[0] = null;
         this.extensionKeywords[0] = 196;
      } else {
         this.nbExtensions = 0;
      }

      this.outMsgid = null;
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

      this.aqm.initToDefaultValues();
      this.aqm.aqmpri = this.messageProperties.getPriority();
      this.aqm.aqmdel = this.messageProperties.getDelay();
      this.aqm.aqmexp = this.messageProperties.getExpiration();
      this.aqm.aqmcorBytes = this.aqmcorBytes;
      this.aqm.aqmeqnBytes = this.aqmeqnBytes;
      this.aqm.senderAgentName = this.senderAgentName;
      this.aqm.senderAgentAddress = this.senderAgentAddress;
      this.aqm.senderAgentProtocol = this.senderAgentProtocol;
      this.aqm.originalMsgId = this.messageProperties.getPreviousQueueMessageId();
      this.aqm.marshal();
      AQAgentI[] var1 = (AQAgentI[])((AQAgentI[])this.messageProperties.getRecipientList());
      if (var1 != null && var1.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(var1.length * 3);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalSB4(this.enqueueOptions.getVisibility().getCode());
      boolean var2 = false;
      if (this.enqueueOptions.getRelativeMessageId() != null && this.enqueueOptions.getRelativeMessageId().length > 0) {
         var2 = true;
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.enqueueOptions.getRelativeMessageId().length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalSWORD(this.enqueueOptions.getSequenceDeviation().getCode());
      this.meg.marshalPTR();
      this.meg.marshalSWORD(16);
      this.meg.marshalUB2(1);
      if (!this.isRawQueue) {
         this.meg.marshalPTR();
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.messageData.length);
      }

      if (this.enqueueOptions.getRetrieveMessageId()) {
         this.retrieveMessageId = true;
         this.meg.marshalPTR();
         this.meg.marshalSWORD(16);
      } else {
         this.retrieveMessageId = false;
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      int var3 = 0;
      if (this.connection.autocommit) {
         var3 = 32;
      }

      if (this.enqueueOptions.getDeliveryMode() == AQEnqueueOptions.DeliveryMode.BUFFERED) {
         var3 |= 2;
      }

      this.meg.marshalUB4((long)var3);
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      if (this.nbExtensions > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.nbExtensions);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalNULLPTR();
      this.meg.marshalSWORD(0);
      this.meg.marshalNULLPTR();
      this.meg.marshalSWORD(0);
      this.meg.marshalNULLPTR();
      if (this.connection.getTTCVersion() >= 4) {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
         this.meg.marshalNULLPTR();
         this.meg.marshalNULLPTR();
      }

      if (this.queueNameBytes != null && this.queueNameBytes.length != 0) {
         this.meg.marshalCHR(this.queueNameBytes);
      }

      if (var1 != null && var1.length > 0) {
         this.meg.marshalKPDKV(this.recipientTextValues, this.recipientBinaryValues, this.recipientKeywords);
      }

      if (var2) {
         this.meg.marshalB1Array(this.enqueueOptions.getRelativeMessageId());
      }

      this.meg.marshalB1Array(this.messageOid);
      if (!this.isRawQueue) {
         this.toh.init(this.messageOid, this.messageData.length);
         this.toh.marshal(this.meg);
         this.meg.marshalCLR(this.messageData, 0, this.messageData.length);
      } else {
         this.meg.marshalB1Array(this.messageData);
      }

      if (this.nbExtensions > 0) {
         this.meg.marshalKPDKV(this.extensionTextValues, this.extensionBinaryValues, this.extensionKeywords);
      }

   }

   byte[] getMessageId() {
      return this.outMsgid;
   }

   void readRPA() throws SQLException, IOException {
      if (this.retrieveMessageId) {
         this.outMsgid = new byte[16];
         this.meg.unmarshalBuffer(this.outMsgid, 0, 16);
      }

      int var1 = this.meg.unmarshalUB2();
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
