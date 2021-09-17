package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.JMSEnqueueOptions;
import oracle.jdbc.internal.JMSMessageProperties;

public class T4CTTIoaqenq extends T4CTTIfun {
   T4CTTIaqm aqm;
   T4Ctoh toh;
   T4CTTIaqjms aqjms;
   private JMSEnqueueOptions enqueueOptions = null;
   private AQMessagePropertiesI messageProperties = null;
   private JMSMessageProperties jmsProp = null;
   private byte[] aqmcorBytes;
   private byte[] aqmeqnBytes;
   private byte[] senderAgentName = null;
   private byte[] senderAgentAddress = null;
   private byte senderAgentProtocol = 0;
   private byte[] messageData = null;
   private byte[] messageOid = null;
   private AQAgentI[] attrRecipientList = null;
   private byte[][] recipientTextValues = (byte[][])null;
   private byte[][] recipientBinaryValues = (byte[][])null;
   private int[] recipientKeywords = null;
   private byte[] queueNameBytes = null;
   private byte[] outMsgId = null;
   private int bitMappedEnqueueOption = 0;
   private byte[] headerPropBytes;
   private byte[] userPropBytes;
   private boolean retrieveMessageId = false;

   T4CTTIoaqenq(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)184);
      this.toh = new T4Ctoh();
      this.aqm = new T4CTTIaqm(this.connection, this.toh);
      this.aqjms = new T4CTTIaqjms(this.connection);
   }

   void doJMSEnq(String var1, JMSEnqueueOptions var2, AQMessagePropertiesI var3, JMSMessageProperties var4, byte[] var5, byte[] var6) throws SQLException, IOException {
      this.enqueueOptions = var2;
      this.messageProperties = var3;
      this.jmsProp = var4;
      this.messageData = var6;
      if (this.messageProperties != null) {
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
      } else {
         this.aqmcorBytes = null;
         this.aqmeqnBytes = null;
         this.senderAgentName = null;
         this.senderAgentAddress = null;
         this.senderAgentProtocol = 0;
      }

      this.messageData = var6;
      this.messageOid = var5;
      if (var1 != null && var1.length() != 0) {
         this.queueNameBytes = this.meg.conv.StringToCharBytes(var1);
      } else {
         this.queueNameBytes = null;
      }

      this.bitMappedEnqueueOption = var2.getDeliveryMode().getCode() + var2.getVisibility().getCode();
      if (this.jmsProp != null) {
         this.headerPropBytes = this.meg.conv.StringToCharBytes(this.jmsProp.getHeaderProperties());
         this.userPropBytes = this.meg.conv.StringToCharBytes(this.jmsProp.getUserProperties());
      } else {
         this.headerPropBytes = null;
         this.userPropBytes = null;
      }

      this.outMsgId = null;
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
      if (this.messageProperties != null) {
         this.aqm.aqmpri = this.messageProperties.getPriority();
         this.aqm.aqmdel = this.messageProperties.getDelay();
         this.aqm.aqmexp = this.messageProperties.getExpiration();
         this.aqm.originalMsgId = this.messageProperties.getPreviousQueueMessageId();
      }

      this.aqm.aqmcorBytes = this.aqmcorBytes;
      this.aqm.aqmeqnBytes = this.aqmeqnBytes;
      this.aqm.senderAgentName = this.senderAgentName;
      this.aqm.senderAgentAddress = this.senderAgentAddress;
      this.aqm.senderAgentProtocol = this.senderAgentProtocol;
      this.aqm.marshal();
      this.meg.marshalSB4(this.bitMappedEnqueueOption);
      if (this.jmsProp != null) {
         this.aqjms.aqjmsflags = this.jmsProp.getJMSMessageType().getCode();
         this.aqjms.aqjmshdrpcnt = 0;
         this.aqjms.aqjmsusrprpcnt = 0;
      } else {
         this.aqjms.aqjmsflags = 0;
         this.aqjms.aqjmshdrpcnt = 0;
         this.aqjms.aqjmsusrprpcnt = 0;
      }

      this.aqjms.aqjmshdrprop = this.headerPropBytes;
      this.aqjms.aqjmsuserprop = this.userPropBytes;
      this.aqjms.marshal();
      if (this.messageOid != null) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(16);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalUB2(1);
      this.meg.marshalNULLPTR();
      if (this.messageData != null) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.messageData.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalSB4(0);
      if (this.enqueueOptions.isRetrieveMessageId()) {
         this.retrieveMessageId = true;
         this.meg.marshalPTR();
         this.meg.marshalSWORD(16);
      } else {
         this.retrieveMessageId = false;
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      if (this.queueNameBytes != null && this.queueNameBytes.length != 0) {
         this.meg.marshalCHR(this.queueNameBytes);
      }

      if (this.messageOid != null) {
         this.meg.marshalB1Array(this.messageOid);
      }

      if (this.messageData != null) {
         this.meg.marshalB1Array(this.messageData);
      }

   }

   void readRPA() throws SQLException, IOException {
      if (this.retrieveMessageId) {
         this.outMsgId = new byte[16];
         this.meg.unmarshalBuffer(this.outMsgId, 0, 16);
      }

   }

   public byte[] getMsgId() {
      return this.outMsgId;
   }
}
