import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.NullWritable;

public class MeanCrashReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

    	Double sum = 0.0;
    	int num = 0;
        for (IntWritable value : values) {
        	num += 1;
            sum +=  value.get();
        }

        Double average = sum/num;
	String output = average.toString();

        context.write(new Text(output), new IntWritable(num));
        
    }
}
