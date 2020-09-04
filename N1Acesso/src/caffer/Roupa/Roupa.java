package caffer.Roupa;

import java.time.LocalDate;

import caffer.Crud.Metodos;

public class Roupa {
	public Roupa() {
		super();
	}
	public Roupa(String dataEntrega, String localDaCompra, String tipo, String marca, String caracteristicas,
			Tamanho tamanho, Cor cor, double valorEtiqueta, double valorPago,
			double valorSugerido) {
		super();
		String arquivo = Metodos.lerArquivoTexto("Dados.txt");
		this.codigoItem = Metodos.proximoId(arquivo);
		this.setDataEntrega(dataEntrega);
		this.localDaCompra = localDaCompra;
		this.tipo = tipo;
		this.marca = marca;
		this.caracteristicas = caracteristicas;
		this.tamanho = tamanho;
		this.cor = cor;
		this.valorEtiqueta = valorEtiqueta;
		this.valorPago = valorPago;
		this.valorParaMargemDe100Porc = this.valorPago * 2;
		this.valorSugerido = valorSugerido;
	}
	private int codigoItem;
	private LocalDate dataEntrega;
	private String localDaCompra;
	private String tipo;
	private String marca;
	private String caracteristicas;
	private Tamanho tamanho; 
	private Cor cor;
	private double valorEtiqueta;
	private double valorPago;
	private double valorParaMargemDe100Porc;
	private double valorSugerido;
	public int getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String data) {
		String[] vetorData = data.split("-");
		int dia = Integer.parseInt(vetorData[0]);
		int mes = Integer.parseInt(vetorData[1]);
		int ano = Integer.parseInt(vetorData[2]);
		this.dataEntrega = LocalDate.of(ano, mes, dia);
	}
	public String getLocalDaCompra() {
		return localDaCompra;
	}
	public void setLocalDaCompra(String localDaCompra) {
		this.localDaCompra = localDaCompra;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public double getValorEtiqueta() {
		return valorEtiqueta;
	}
	public void setValorEtiqueta(double valorEtiqueta) {
		this.valorEtiqueta = valorEtiqueta;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
		this.valorParaMargemDe100Porc = valorPago * 2;
	}
	public double getValorParaMargemDe100Porc() {
		return valorParaMargemDe100Porc;
	}
	public double getValorSugerido() {
		return valorSugerido;
	}
	public void setValorSugerido(double valorSugerido) {
		this.valorSugerido = valorSugerido;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	
	
}
