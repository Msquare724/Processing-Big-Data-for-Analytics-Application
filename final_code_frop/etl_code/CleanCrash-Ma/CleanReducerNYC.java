import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.NullWritable;

public class CleanReducerNYC extends Reducer<Text, IntWritable, Text, NullWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

    	int sum = 0;
        for (IntWritable value : values) {
            sum +=  value.get();
        }

        context.write(new Text(key.toString()+ "," +sum), NullWritable.get());

}}
