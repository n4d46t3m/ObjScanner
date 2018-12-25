package org.n4d46t3m.test;

public class TestsOptsManager {
    
    private String banner = new String();
    private final double version = 1.0;
    private boolean userWait = false;
    
    public TestsOptsManager() {
        this.setBanner();
    }
    
    private String getBanner() {
        return this.banner;
    }

    private void setBanner() {
        StringBuilder banner = new StringBuilder();
        banner
           .append("  ___  _     _ ____                                  \n")
           .append(" / _ \\| |__ (_) ___|  ___ __ _ _ __  _ __   ___ _ __ \n")
           .append("| | | | '_ \\| \\___ \\ / __/ _` | '_ \\| '_ \\ / _ \\ '__|\n")
           .append("| |_| | |_) | |___) | (_| (_| | | | | | | |  __/ |   \n")
           .append(" \\___/|_.__// |____/ \\___\\__,_|_| |_|_| |_|\\___|_|   \n")
           .append("          |__/                                       \n");
        this.banner=banner.toString();

    }

    public boolean getUserWait() {
        return this.userWait;
    }
    
    protected String printUsage() {
        
        StringBuilder usage = new StringBuilder();
        
        usage.append(this.getBanner())
            .append("\n\n")
            .append("Options:\n")
            .append("\t-w Wait for user input to continue tests\n")
            .append("\t-v Print software version\n")
            .append("\t-h Print this message\n");
        
        return usage.toString();
        
    }
    
    protected String printVersion() {
        
        StringBuilder versionMsg = new StringBuilder();
        
        versionMsg.append(this.getBanner())
            .append("\nVERSION ")
            .append(this.version)
            .append(" dreaming beautiful things...\n");
        
        return versionMsg.toString();
        
    }
    
    protected String printUncknown() {
        
        StringBuilder uncknownOptMsg = new StringBuilder();
        uncknownOptMsg.append(this.getBanner())
            .append("\nUncknown option..\n");
        
        return uncknownOptMsg.toString();
        
    }

}
