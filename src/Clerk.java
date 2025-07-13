public class Clerk {
    private WorkerInfo workerInfo;

    public Clerk() {
        this.workerInfo = null;
    } 
    
    public Clerk(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }

    public WorkerInfo getWorkerInfo() {
        return workerInfo;
    }

    public void setWorkerInfo(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }
}
