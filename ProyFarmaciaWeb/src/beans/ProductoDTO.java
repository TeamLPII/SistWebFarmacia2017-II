package beans;

public class ProductoDTO {
	private int cod_prod;
	private String nom_prod;
	private double pre_prod;
	private int stk_prod;
	private int cod_cat;
	private int cod_lab;
	private String nom_cat;
	private String nom_lab;
	
	public int getCod_prod() {
		return cod_prod;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public double getPre_prod() {
		return pre_prod;
	}
	public int getStk_prod() {
		return stk_prod;
	}
	public int getCod_cat() {
		return cod_cat;
	}
	public int getCod_lab() {
		return cod_lab;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public String getNom_lab() {
		return nom_lab;
	}
	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}
	public void setPre_prod(double pre_prod) {
		this.pre_prod = pre_prod;
	}
	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}
	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}
	public void setCod_lab(int cod_lab) {
		this.cod_lab = cod_lab;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	public void setNom_lab(String nom_lab) {
		this.nom_lab = nom_lab;
	}

	
}
