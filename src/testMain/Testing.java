package testMain;

import utils.DynamodbTableConfig;
import module.DBModule;
import interfaces.DynamodbTableService;

import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Testing {
	@Inject 
	DynamodbTableService tableHandler;
	
	@Inject Provider<DynamodbTableConfig> tableConfigProvider;
	
//	@Inject
//	public Testing(DynamodbTableService tableHandler) {
//		this.tableHandler = tableHandler;
//	}
	
	public void doTesting() {
//		tableHandler.testing();
//		tableHandler.createTable(new DynamodbTableConfig().withName("t1").withField("f1", KeyType.HASH));
		tableConfigProvider.get();
		System.out.println("--------");
		tableHandler.createTable(tableConfigProvider.get());
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new DBModule());
		Testing t = injector.getInstance(Testing.class);
		t.doTesting();
	}
}
