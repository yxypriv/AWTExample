package interfaces.impl;

import utils.DynamodbTableConfig;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.google.inject.Singleton;

import interfaces.DynamodbTableService;

@Singleton
public class DynamodbTableServiceImpl implements DynamodbTableService {
	static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
            new ProfileCredentialsProvider()));
	
	@Override
	public Table createTable(DynamodbTableConfig config) {
		return dynamoDB.createTable(new CreateTableRequest()//
				.withTableName(config.getTableName()).withKeySchema(config.getSchema()));
	}

	@Override
	public void testing() {
		System.out.println("testing went well");
	}

}
