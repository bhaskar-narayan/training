class Constant {
    final static int spendingLimitMP = 100000;
    final static int spendingLimitPM = 10000000;
    final static int spendingLimitMinister = 1000000;
}

class Aircraft {
    String getCraft() {
        return "Aircraft";
    }
}

class Constituency {
    String getName() {
        return "Noida";
    }
}

class Driver {
    String getName() {
        return "Gaytonde";
    }
}

class Commisioner {
    MP mp;
    boolean permision;

    void setPermission(boolean permission) {
        this.permision = permission;
    }

    boolean canArrest(MP mp) {
        if (mp.getClass().getSimpleName().equals("MP")) {
            if (mp.spending > Constant.spendingLimitMP)
                return true;
        }
        if (mp.getClass().getSimpleName().equals("Minister") || permision) {
            if (mp.spending > Constant.spendingLimitMinister)
                return true;
        }
        if (mp.getClass().getSimpleName().equals("PM")) {
            if (mp.spending > Constant.spendingLimitPM)
                return true;
        }
        return false;
    }
}

class MP {
    String name;
    int spending;
    String constituencyName;
    String driverName;

    void setDetail(String name, int spending) {
        this.name = name;
        this.spending = spending;
    }

    Constituency constituency = new Constituency();
    Driver driver = new Driver();

    String getConstituency() {
        constituencyName = constituency.getName();
        return constituencyName;
    }

    String getDriver() {
        driverName = driver.getName();
        return driverName;
    }
}

class Minister extends MP {

}

class PM extends MP {
    void givePermission(Commisioner commisioner) {
        commisioner.setPermission(true);
    }

    Aircraft aircraft = new Aircraft();
}

public class Main2 {
    public static void main(String[] args) {
        // MP mp = new PM();
        // mp.setDetail("Bhaskar Narayan", 6001);
        // mp.getDriver();
        // mp.getConstituency();
        // System.out.println(mp.constituencyName);
        // System.out.println(mp.driverName);
        // System.out.println(mp.spending);
        // Commisioner commisioner = new Commisioner();
        // boolean result = commisioner.canArrest(mp);
        // System.out.println(result);
        MP minister = new Minister();
        Commisioner commisioner = new Commisioner();
        MP pm = new PM();
        
    }
}