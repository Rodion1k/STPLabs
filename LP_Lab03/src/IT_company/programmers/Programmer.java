package IT_company.programmers;

import IT_company.Worker;

public abstract class Programmer extends Worker{

    public Programmer(byte workExperience, SkillsLevel skillsLevel, float salary) {
        super(workExperience, skillsLevel, salary);
    }

    public abstract void startProgramming();

}
