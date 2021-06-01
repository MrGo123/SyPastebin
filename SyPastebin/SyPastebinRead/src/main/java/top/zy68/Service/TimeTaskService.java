package top.zy68.Service;


public interface TimeTaskService {
    /**
     * 定时任务
     * 定时执行清理过期的paste内容的任务
     */
    void cleanOverdueData();
}
