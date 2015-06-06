package utils;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;

public class DynamodbTableConfig {
	String tableName;
	List<KeySchemaElement> schema;
	
	public DynamodbTableConfig() {
		schema = new ArrayList<KeySchemaElement>();
	}
	
	public DynamodbTableConfig withName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	
	public DynamodbTableConfig withField(String fieldName, String fieldType) {
		this.schema.add(new KeySchemaElement(fieldName, KeyType.fromValue(fieldType)));
		return this;
	}
	
	public DynamodbTableConfig withField(String fieldName, KeyType fieldType) {
		this.schema.add(new KeySchemaElement(fieldName, fieldType));
		return this;
	}
	
	public DynamodbTableConfig withField(KeySchemaElement schemaElement) {
		this.schema.add(schemaElement);
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<KeySchemaElement> getSchema() {
		return schema;
	}

	public void setSchema(List<KeySchemaElement> schema) {
		this.schema = schema;
	}
	
	
}
