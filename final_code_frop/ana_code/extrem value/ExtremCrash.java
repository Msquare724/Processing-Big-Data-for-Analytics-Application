import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ExtremCrash {
    public static void main(String[] args) throws Exception { if (args.length != 2) {
        System.err.println("Usage: ExtremCrash <input path> <output path>");
        System.exit(-1);
    }
        Job job = new Job();
        job.setJarByClass(ExtremCrash.class);
        job.setJobName("ExtremCrash");
        FileInputFormat.addInputPath(job, new Path(args[0])); FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(extremCrashMapper.class);
        job.setReducerClass(extremCrashReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(1);
        System.exit(job.waitForCompletion(true) ? 0 : 1); }
}
