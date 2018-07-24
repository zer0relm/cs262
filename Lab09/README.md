This code implements a Google Cloud AppEngine application that
integrates a Cloud SQL (Postgresql) database with an Endpoints REST
API. It is deployed to a Google Cloud project that has resources for
AppEngine and Cloud SQL. Only the read API endpoints are implemented.

Put detailed construction/configuration/use instructions here,
including:

1. Set up for the Google Cloud Project (with billing, Cloud SQL,
AppEngine, JDBC service?, deactivation/activation) - Note that the
project/billing/DB may have been built in an earlier lab.

2. Lab 9 code overview and deployment instructions (helloWorld,
getPlayer & getPlayers) - They'll need to clone my sample lab09, copy
it into a sub-directory of their repo, delete the .git sub-directory in
the project and git-add/commit/push the new sub-directory to their git
repo. The repo name will stay the same - "Lab09".

3. Homework 3 instructions (putPlayer, postPlayer, deletePlayer)

They'll need to set the CLOUDSQL system variable.
    <ol>
        <li><p>Create a Google Cloud SQL project.</p>
            <ol type="a">
                <li>Create a <a href="https://cloud.google.com/" target="_blank" class="external">Google
                    Cloud account</a>.
                </li>
                <li>Create a "new project" with your team's billing account/organization. We will
                    provide you with a billing account. Name your project <code>calvincs262a</code>.
                </li>
                <li>Add an "SQL" instance of PostgreSQL (deploy on <code>us-east4</code>, any zone,
                    minimal configuration-no-backups).
                </li>
            </ol>
            <p>Note that these steps can take some time.</p>
        </li>

        <li><p>Port the sample lab 9 code to your Google Cloud Project.</p>
            <ol type="a">
                <li>Clone the Lab09 code from the course code repo and redirect it to your own repo.
                </li>
                <li>Run the hello-endpoint application locally using gcloud. You should be able to
                    find a hello-world message at the following route:
                    <ul>
                        <blockquote><code>http://localhost:9998/monopoly/hello</code></blockquote>
                    </ul>
                </li>
                <li>Use the endpoints-app tutorial commands to deploy the app. (gcloud auth login
                    (choose your Cloud account), ...).
                </li>
                <li>In <code>pom.xml</code>, set the instance-connection-name (to the Cloud SQL
                    name) and <code>endpoints.project.id</code> to the main Google Cloud project
                    name.
                </li>
            </ol>
        </li>

        <p>You&rsquo;ll modify this application below.</p>
