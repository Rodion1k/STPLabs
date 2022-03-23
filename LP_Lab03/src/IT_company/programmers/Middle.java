package IT_company.programmers;

public class Middle extends Programmer {
    private static float coefficient = 1.7f;

    public Middle(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }

    @Override
    public void setSalary(float salary) {
        super.setSalary(salary * coefficient);
    }

    @Override
    public void startWork() {
        super.startWork();
        startProgramming();
    }


    @Override
    public String toString() {
        return String.format("Middle programmer: workExperience = %d, skillsLevel = %s, salary = %f", getWorkExperience(), getSkillsLevel(), getSalary());
    }

    @Override
    public void startProgramming() {
        System.out.println("middle start programming");
    }
}
