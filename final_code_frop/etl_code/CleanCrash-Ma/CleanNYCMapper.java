import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanNYCMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String data[] = value.toString().split(",");

        if((data[2].trim()).length() > 2){

            String date = data[0];
            String crashTime = data[1];
            String hour[] = crashTime.toString().split(":");
            String hourOutput = hour[0];
            String crashRegion = data[2];
            String output = date + "," + hourOutput + "," + crashRegion;

            context.write(new Text(output), new IntWritable(1));
        }
    }
} 

