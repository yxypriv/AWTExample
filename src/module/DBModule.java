package module;

import utils.DynamodbTableConfig;
import interfaces.DynamodbTableService;
import interfaces.impl.DynamodbTableServiceImpl;

import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class DBModule extends AbstractModule {

	@Override
	protected void configure() {
		System.out.println("Config Applied...");
		bind(DynamodbTableService.class).to(DynamodbTableServiceImpl.class);
	}
	
//	@Singleton
	@Provides
	DynamodbTableConfig getyableConfig() {
		System.out.println("Table Config Generated");
		return new DynamodbTableConfig().withName("name").withField("field1", KeyType.HASH).withField("field2", KeyType.RANGE);
	}

}
