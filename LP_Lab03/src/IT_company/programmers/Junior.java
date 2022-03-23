package IT_company.programmers;

import IT_company.Worker;

public class Junior extends Programmer {
    private static float coefficient = 1.2f;

    public Junior(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }

    @Override
    public void setSalary(float salary) {
        super.setSalary(salary*coefficient);
    }

    @Override
    public void startWork() {
        super.startWork();
        startProgramming();
    }

    @Override
    public void startProgramming() {
        System.out.println("junior start programming");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Junior programmer: workExperience = %d, skillsLevel = %s, salary = %f",getWorkExperience(), getSkillsLevel(), getSalary());
    }
}
