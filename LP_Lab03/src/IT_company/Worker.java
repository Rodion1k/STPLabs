package IT_company;

import IT_company.programmers.SkillsLevel;

public abstract class Worker {
    private byte workExperience;
    private SkillsLevel skillsLevel;
    private float salary;
    private static float coefficient = 1f;

    public Worker(byte workExperience, SkillsLevel skillsLevel, float salary) {
        setWorkExperience(workExperience);
        this.skillsLevel = skillsLevel;
        setSalary(salary);
    }

    public byte getWorkExperience() {
        return workExperience;
    }

    public SkillsLevel getSkillsLevel() {
        return skillsLevel;
    }

    public float getSalary() {
        return salary;
    }

    public void setWorkExperience(byte workExperience) {
        this.workExperience = workExperience;
    }

    public void setSalary(float salary) {
        this.salary = salary*coefficient;
    }


    public void startWork() {
        System.out.println("worker start work");
    }

}
