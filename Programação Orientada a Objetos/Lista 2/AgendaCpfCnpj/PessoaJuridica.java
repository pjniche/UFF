public class PessoaJuridica extends Pessoa {
  private String razaoSocial;
  private String cnpj;

  public PessoaJuridica(String razaoSocial, String cnpj, String endereco) {
    setRazaoSocial(razaoSocial);
    setCnpj(cnpj);
    setEndereco(endereco);
  }

  public void setRazaoSocial( String razaoSocial ) {
    this.razaoSocial = razaoSocial;
  }

  public void setCnpj(String cnpj ) {
    this.cnpj = cnpj;
  }

  public String getId() {
    return cnpj;
  }
	
	public String toString() {
		return ("Razao social: " + razaoSocial + "\nCNPJ: " + cnpj + "\nEndereco: " + endereco + "\n");
  }
}