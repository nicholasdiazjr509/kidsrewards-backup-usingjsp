package com.codeup.kidsrewardscapstone.controllers;

import com.codeup.kidsrewardscapstone.models.Reward;
import com.codeup.kidsrewardscapstone.models.Status;
import com.codeup.kidsrewardscapstone.models.Task;
import com.codeup.kidsrewardscapstone.models.User;
import com.codeup.kidsrewardscapstone.repositories.StatusRepository;
import com.codeup.kidsrewardscapstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.kidsrewardscapstone.repositories.TaskRepository;

@Controller
public class TaskController {
    //added status repo and constructor
    private StatusRepository statusDao;
    private TaskRepository taskDao;
    private UserRepository usersDao;

    public TaskController(StatusRepository statusDao, TaskRepository taskDao, UserRepository usersDao) {
        this.statusDao = statusDao;
        this.taskDao = taskDao;
        this.usersDao = usersDao;
    }
    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        model.addAttribute("allTasks", taskDao.findAll());
        return "tasks/index";
    }

    @GetMapping("/tasks/{id}")
    public String taskDetails(@PathVariable long id, Model model) {
        model.addAttribute("singleTask", taskDao.getById(id));
        return "tasks/show";
    }

    @GetMapping("/tasks/create")
    public String showCreateForm(Model model) {
        model.addAttribute("newTask", new Task());
        return "tasks/create";
    }

    @PostMapping("/tasks/create")
    public String create(
            @RequestParam(name = "icon") String icon,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "points") Long points
    ) {
        Task task = new Task();
        task.setIcon(icon);
        task.setTitle(title);
        task.setDescription(description);
        task.setPoints(points);
//        reward.getId(rewardId);

        taskDao.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String showEditRewardForm(@PathVariable long id, Model model) {
        model.addAttribute("rewardToEdit", taskDao.getById(id));
        return "tasks/edit";
    }

    @PostMapping("/tasks/{id}/edit")
    public String submitRewardToEdit(@ModelAttribute Task taskToEdit, @PathVariable long id) {
        taskToEdit.setUser(usersDao.getById(1L));
        taskDao.save(taskToEdit);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/tasks/{id}/delete")
    public String delete(@PathVariable long id) {
        taskDao.deleteById(id);
        return "redirect:/tasks";
    }

}

//    @GetMapping("/tasks")
//    public String showTasks(Model model) {
//        model.addAttribute("task", new Task());
//        return "tasks/task";
//    }
//
//}

//  _____________ Status ____________//


//
//@GetMapping("/statuses/{id}/edit")
//public String showEditStatus(@PathVariable long id, Model model) {
//    Status statusToEdit = statusDao.getById(id);
//    User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    if (statusToEdit.getUser().getId() == loggedInUser.getId()) {
//        model.addAttribute("statusToEdit", statusToEdit);
//        return "statuses/edit";
//    } else {
//        return "redirect:/status";//?? or redirect tasks??
//    }
//}
//    //to show the edit of status?
//    @PostMapping("/statuses/{id}/edit")
//    public String submitEdit(@ModelAttribute Status statusToEdit, @PathVariable long id) {
//        if (statusDao.getById(id).getUser().getId() == ((User) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal()).getId()) {
//            statusToEdit.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//
//            statusDao.save(statusToEdit);
//        }
//        return "redirect:/status";
//    }
//}
