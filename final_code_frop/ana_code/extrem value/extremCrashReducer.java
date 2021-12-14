import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.NullWritable;

public class extremCrashReducer extends Reducer<Text, IntWritable, Text, NullWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {


        for (IntWritable value : values) {
            context.write(new Text(key.toString()+ "," + value),  NullWritable.get());
        }

        

}}
