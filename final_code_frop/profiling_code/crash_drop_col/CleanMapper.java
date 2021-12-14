import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String data[] = value.toString().split(",");

 
            String time = data[3];
            String crashType = data[16];
            String st_num = data[24];
            String output = time + "," + crashType + "," + st_num;
            

        	context.write(new Text(output), new IntWritable(1));

        

    }
} 

