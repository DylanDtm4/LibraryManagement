public class Librarian {
    private WorkerInfo workerInfo;

    public Librarian() {
        this.workerInfo = null;
    } 
    
    public Librarian(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }

    public WorkerInfo getWorkerInfo() {
        return workerInfo;
    }

    public void setWorkerInfo(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }
}
