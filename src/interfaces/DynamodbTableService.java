package interfaces;

import utils.DynamodbTableConfig;

import com.amazonaws.services.dynamodbv2.document.Table;

public interface DynamodbTableService {
	Table createTable(DynamodbTableConfig config);
	void testing();
}
