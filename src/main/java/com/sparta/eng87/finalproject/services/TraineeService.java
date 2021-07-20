package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.repositories.CourseRepository;
import com.sparta.eng87.finalproject.repositories.QualityGateRepository;
import com.sparta.eng87.finalproject.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeService {

    private TraineeRepository traineeRepository;
    private CourseRepository courseRepository;

    @Autowired
    public TraineeService(TraineeRepository traineeRepository,CourseRepository courseRepository, QualityGateRepository qualityGateRepositoryAdd) {
        this.traineeRepository = traineeRepository;
        this.courseRepository=courseRepository;
    }

    public void addTrainee(TraineeEntity traineeEntity){
        traineeRepository.save(traineeEntity);
    }


    public List<Object[]> findTraineeByCourse(String courseName) {

        int courseId = courseRepository.findCourseIdByCourseName(courseName);
        List<Object[]> trainees = traineeRepository.getTraineesByCourseId(courseId);

        List<String> duplicates = new ArrayList<>();
        List<Object[]> results = new ArrayList<>();

        for(Object[] trainee: trainees){
            if (trainee[2] == (null)){
                trainee[2] = "Pending";
            }
        }

        for (int i = 0; i < trainees.size(); i++) {
            if (duplicates.contains(trainees.get(i)[3])) {
                for (int j = 0; j < results.size(); j++) {
                    if ((results.get(j)[3].equals(trainees.get(i)[3]) )) {
                        if (trainees.get(i).toString().equalsIgnoreCase("passed")) {
                            results.remove(j);
                            results.add(trainees.get(i));
                            break;
                        }
                        else if (results.get(j)[2].toString().equalsIgnoreCase("failed-needs support")) {
                            break;
                        }
                        else if (results.get(j)[2].toString().equalsIgnoreCase("failed")) {
                            results.remove(j);
                            results.add(trainees.get(i));
                            break;
                        }
                        else{
                            results.get(j)[2] = "Pending";
                            break;
                        }
                    }
                }
            } else {
                results.add(trainees.get(i));
                duplicates.add(trainees.get(i)[3].toString());
            }
        }
        return results;
//        return trainees;


    }
        public TraineeEntity getTraineeById (Integer id){
            return traineeRepository.getById(id);
        }

        public void deleteTrainee (Integer id){
            traineeRepository.deleteById(id);
        }

    public List<Object[]> getAllTrainees(){

        List<Object[]> trainees = traineeRepository.getAllTrainees();
        List<String> duplicates = new ArrayList<>();
        List<Object[]> results = new ArrayList<>();

        for(Object[] trainee: trainees){
            if (trainee[2] == (null)){
                trainee[2] = "Pending";
            }
        }

        for (int i = 0; i < trainees.size(); i++) {
            if (duplicates.contains(trainees.get(i)[3])) {
                for (int j = 0; j < results.size(); j++) {
                    if ((results.get(j)[3].equals(trainees.get(i)[3]) )) {
                        if (trainees.get(i).toString().equalsIgnoreCase("passed")) {
                            results.remove(j);
                            results.add(trainees.get(i));
                            break;
                        }
                        else if (results.get(j)[2].toString().equalsIgnoreCase("failed-needs support")) {
                            break;
                        }
                        else if (results.get(j)[2].toString().equalsIgnoreCase("failed")) {
                            results.remove(j);
                            results.add(trainees.get(i));
                            break;
                        }
                        else{
                            results.get(j)[2] = "Pending";
                            break;
                        }
                    }
                }
            } else {
                results.add(trainees.get(i));
                duplicates.add(trainees.get(i)[3].toString());
            }
        }
        return results;
    }
}
