package IT_company.programmers;

public class Senior extends Programmer{
    private static float coefficient = 2.2f;

    public Senior(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }

    public void setSalary(float salary) {
       super.setSalary(salary*coefficient);
    }
    @Override
    public void startWork() {
        super.startWork();
        startProgramming();
    }


    @Override
    public String toString() {
        return String.format("Senior programmer: workExperience = %d, skillsLevel = %s, salary = %f", getWorkExperience(), getSkillsLevel(), getSalary());
    }
    @Override
    public void startProgramming() {
        System.out.println("senior start programming");
    }
}
