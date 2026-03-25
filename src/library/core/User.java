package library.core;

public class User {
    
    private String name;
    private boolean isPremium;

    public User(String name) {
        this(name, false);
    }

    public User(String name, boolean isPremium) {
        validateName(name);
        this.name = name.trim();
        this.isPremium = isPremium;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
    
    @Override
    public String toString() {
        return String.format("User{name='%s', isPremium=%s}", name, isPremium);
    }
}