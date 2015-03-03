package evote.dao;

public enum Query {
	
	QUERY_TEST1_ALL("FROM evote.model.Test1"),
	QUERY_USERS_ALL("FROM evote.model.Usuario");
	private String value;
	
	Query(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}