package dominio;

public class Usuario {

    private int idUsuario;
    private String usuario;
    private String pass;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String pass) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Usuario(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", pass=" + pass + '}';
    }
    

}
