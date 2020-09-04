package caffer.Roupa;

public enum Cor {
	BRANCO("branco"),
	PRETO("preto"),
	AZUL("azul"),
	VERMELHO("vermelho"),
	VERDE("verde");
	
	private String descricao;
	
	Cor(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
