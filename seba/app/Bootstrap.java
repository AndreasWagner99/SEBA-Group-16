import models.Appl;
import models.Designer;
import models.Project;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;


@OnApplicationStart
public class Bootstrap extends Job{

	public void doJob(){
		if(Project.count() == 0 && Appl.count() == 0 && Designer.count() == 0){
			Fixtures.loadModels("basedata.yml");
		}
	}
}
