package caffer.Roupa;

public enum Tamanho {
	P("p"),
	M("m"),
	G("g");
		
	private String descricao;
			
	Tamanho(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
