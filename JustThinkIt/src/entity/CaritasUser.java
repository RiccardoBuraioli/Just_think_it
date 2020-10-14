package entity;

public class CaritasUser {

    private int id;
    private String nomeCaritas;
    private String password;
    private String indirizzoCaritas;
    private int tipologia;
    private String recapitoTelefonico;
    private String email;
    private String città;
    private final String TABLE_NAME = "caritas";


    public CaritasUser() {
    }

    public CaritasUser(String nomeCaritas, String passwordCaritas, String indirizzoCaritas, int tipologia, String recapitoTelefonico, String email, String città) {
        this.nomeCaritas = nomeCaritas;
        this.password = passwordCaritas;
        this.indirizzoCaritas = indirizzoCaritas;
        this.tipologia = tipologia;
        this.recapitoTelefonico = recapitoTelefonico;
        this.email = email;
        this.città = città;
    }
    
    public String getCittà() {
    	return città;
    }
    
    public void setCittà( String newcity) {
    	this.città = newcity;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) this.id = id;

    }

    public String getNomeCaritas() {
        return nomeCaritas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzoCaritas() {
        return indirizzoCaritas;
    }

    public int getTipologia() {
        return tipologia;
    }

    public String getRecapitoTelefonico() {
        return recapitoTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setNomeCaritas(String nomeCaritas) {
        this.nomeCaritas = nomeCaritas;
    }

    public void setIndirizzoCaritas(String indirizzoCaritas) {
        this.indirizzoCaritas = indirizzoCaritas;
    }

    public void setTipologia(int tipologia) {
        this.tipologia = tipologia;
    }

    public void setRecapitoTelefonico(String recapitoTelefonico) {
        this.recapitoTelefonico = recapitoTelefonico;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    @Override
    public String toString() {
        return "CaritasUser{" +
                "id=" + id +
                ", nomeCaritas='" + nomeCaritas + '\'' +
                ", password='" + password + '\'' +
                ", indirizzoCaritas='" + indirizzoCaritas + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", recapitoTelefonico='" + recapitoTelefonico + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}