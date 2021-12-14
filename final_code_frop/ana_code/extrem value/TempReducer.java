import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.NullWritable;

public class TempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {


        int max = Integer.MIN_VALUE; 
        int min = 100;
        for (IntWritable value : values) {
        	max = Math.max(max, value.get());
            min = Math.min(min, value.get());
        }


        context.write(new Text("max: " + String.valueOf(max) + " min: "), new IntWritable(min));
       
}}
