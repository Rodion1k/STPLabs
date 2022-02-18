package IT_company.administrators;

import IT_company.Worker;

public class SystemAdministrator extends Worker implements IAdministrative {

    @Override
    public void startManage() {
        System.out.println("System Admin start manage");
    }
}
