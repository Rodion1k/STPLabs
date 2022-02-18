package IT_company.administrators;

import IT_company.Worker;

public class NetworkAdministrator extends Worker implements IAdministrative {

    @Override
    public void startManage() {
        System.out.println("Network Admin start manage");
    }
}
