package Inheritance.StaffRoles;

public class ManagerRole implements Role {
    private final int teamSize;

    public ManagerRole(int teamSize) {
        this.teamSize = teamSize;
    }

    public String describe() {
        return "Manager of " + teamSize + " reports";
    }
}
