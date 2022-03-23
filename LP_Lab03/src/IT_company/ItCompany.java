package IT_company;

import Exceptions.ItCompanyException;
import IT_company.programmers.SkillsLevel;
import main.Main;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class ItCompany<T extends Worker> {
    private static final Logger LOG = Logger.getLogger(ItCompany.class);

    private class Director extends Worker {
        private int getWorkersCount() {
            return workers.size();
        }

        public Director(byte workExperience, SkillsLevel skillsLevel, float salary) {
            super(workExperience, skillsLevel, salary);
        }

        private void sortWorkersBySalary() {
            workers.sort(Comparator.comparing(Worker::getSalary));
        }

        private ArrayList<T> findWorkers(SkillsLevel skillsLevel) {
            ArrayList<T> result = new ArrayList<>();
            for (var i : workers) {
                if (i.getSkillsLevel() == skillsLevel)
                    result.add(i);
            }
            return result;
        }

        @Override
        public String toString() {
            return String.format("Director: workExperience = %d, skillsLevel = %s, salary = %f", getWorkExperience(), getSkillsLevel(), getSalary());
        }
    }

    private ArrayList<T> workers;
    private Director director;

    public ItCompany() {
        workers = new ArrayList<>();
        director = new Director((byte) 1, SkillsLevel.first, 300);
        workers.add((T) director);
        LOG.info("компания создана");
    }

    public void Add(T t) {
        workers.add(t);
        LOG.info("добавлен работник");
    }

    private void showWorkers() throws ItCompanyException {
        if(workers.size()==0)
            throw new ItCompanyException("в компании нету работников");
        director.sortWorkersBySalary();
        LOG.info("произошла сортировка работников");
        for (var i : workers) {
            System.out.println(i);
        }
    }

    public void showWorkersInfo() throws ItCompanyException {
        System.out.println("-----Информация о компании-----");
        System.out.println(director.getWorkersCount());
        showWorkers();
    }

    public void showWorkersBySkills(SkillsLevel skillsLevel) {
        for (var i : director.findWorkers(SkillsLevel.second)) {
            System.out.println(i);
        }
        LOG.info("директор нашел нужных работников");
    }

}
