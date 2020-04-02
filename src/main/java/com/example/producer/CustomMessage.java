package com.example.producer;

public class CustomMessage
{

   private String recordLocator;
   private String transactionId;
   private String sabrePartition;
   private String sourceSabreQueue;
   private String creationTimeStamp;
   private String testCaseID;

   public CustomMessage( String recordLocator,
                         String transactionId,
                         String sabrePartition,
                         String sourceSabreQueue,
                         String creationTimeStamp,
                         String testCaseID )
   {
      this.recordLocator = recordLocator;
      this.transactionId = transactionId;
      this.sabrePartition = sabrePartition;
      this.sourceSabreQueue = sourceSabreQueue;
      this.creationTimeStamp = creationTimeStamp;
      this.testCaseID = testCaseID;
   }

   public String getRecordLocator()
   {
      return recordLocator;
   }

   public void setRecordLocator( String recordLocator )
   {
      this.recordLocator = recordLocator;
   }

   public String getTransactionId()
   {
      return transactionId;
   }

   public void setTransactionId( String transactionId )
   {
      this.transactionId = transactionId;
   }

   public String getSabrePartition()
   {
      return sabrePartition;
   }

   public void setSabrePartition( String sabrePartition )
   {
      this.sabrePartition = sabrePartition;
   }

   public String getSourceSabreQueue()
   {
      return sourceSabreQueue;
   }

   public void setSourceSabreQueue( String sourceSabreQueue )
   {
      this.sourceSabreQueue = sourceSabreQueue;
   }

   public String getCreationTimeStamp()
   {
      return creationTimeStamp;
   }

   public void setCreationTimeStamp( String creationTimeStamp )
   {
      this.creationTimeStamp = creationTimeStamp;
   }

   public String getTestCaseID()
   {
      return testCaseID;
   }

   public void setTestCaseID( String testCaseID )
   {
      this.testCaseID = testCaseID;
   }

}
