package wpd2.lab2.Models;

public class User {

    //Instance Variables
    private int Id;

    private String Name;

    private String Password;

    private String Signature;


    //Getters
    public int GetId() { return Id; }

    public String GetName() { return Name; }

    private String GetPassword() { return Password; }

    public String GetSignature() { return Signature; }


    //Setters
    public void SetId(int Id) { this.Id = Id; }

    public void SetName(String Name) { this.Name = Name; }

    private void SetPassword(String Password) { this.Password = Password; }

    public void SetSignature(String Signature) { this.Signature = Signature; }


    //Constructors

    //Default
    public User() {}

    //Overloaded
    public User(int Id, String Name, String Password, String Signature) {
        this.Id = Id;
        this.Name = Name;
        this.Password = Password;
        this.Signature = Signature;
    }


    //methods
    public boolean CheckPassword(String EnteredPassword) {
        return EnteredPassword.equals(GetPassword());
    }

    public boolean ChangePassword(String OldPassword, String NewPassword) {
        if(CheckPassword(OldPassword))
        {
            SetPassword(NewPassword);
            return true;
        } else {
            return false;
        }
    }
}
