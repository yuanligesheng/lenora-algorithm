package com.example.algorithm.huawei;

import java.util.Arrays;

/**
 * @Author Wang Haoyu
 * @Date 2024/8/18 17:54
 * @Version 1.0
 */
public class Test {

    static class Project {
        String name;
        int hot;

        public Project(String name, int hot) {
            this.name = name;
            this.hot = hot;
        }
    }

    public static void main(String[] args) {
        Project[] projects = new Project[5];
        projects[0] = new Project("s1", 5);
        projects[1] = new Project("s2", 4);
        projects[2] = new Project("s3", 9);
        projects[3] = new Project("s4", 7);
        projects[4] = new Project("s5", 1);

        Arrays.sort(
                projects,(a, b) -> b.hot - a.hot
        );

        for (Project project: projects) {
            System.out.println(project.name + ":" + project.hot);
        }


    }
}
