package entity;

public class ShopUser {

    private int id;
    private String nomeShop;
    private String password;
    private String indirizzoShop;
    private int tipologia;
    private String recapitoTelefonico;
    private String email;
    private String città;
    private final String TABLE_NAME = "negozi";

    public ShopUser() {
    }

    public ShopUser(String nomeShop, String password, String indirizzoShop, int tipologia, String recapitoTelefonico, String email, String città) {
        this.nomeShop = nomeShop;
        this.password = password;
        this.indirizzoShop = indirizzoShop;
        this.tipologia = tipologia;
        this.recapitoTelefonico = recapitoTelefonico;
        this.email = email;
        this.città = città;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) this.id = id;

    }

    public String getNomeShop() {
        return nomeShop;
    }

    public void setNomeShop(String nomeShop) {
        this.nomeShop = nomeShop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzoShop() {
        return indirizzoShop;
    }

    public void setIndirizzoShop(String indirizzoShop) {
        this.indirizzoShop = indirizzoShop;
    }

    public int getTipologia() {
        return tipologia;
    }

    public void setTipologia(int tipologia) {
        this.tipologia = tipologia;
    }

    public String getRecapitoTelefonico() {
        return recapitoTelefonico;
    }

    public void setRecapitoTelefonico(String recapitoTelefonico) {
        this.recapitoTelefonico = recapitoTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    @Override
    public String toString() {
        return "ShopUser{" +
                "nomeShop='" + nomeShop + '\'' +
                ", indirizzoShop='" + indirizzoShop + '\'' +
                ", tipo='" + tipologia + '\'' +
                ", recapito='" + recapitoTelefonico + '\'' +
                '}';
    }

	public String getcittà() {
		return città;
		// TODO Auto-generated method stub
		
	}
	public void setCittà(String newcity) {
		this.città = newcity;
	}
   

	
	
}