//Features:

// ****************************************************************
// Tony Lam (t_l102) code Begin
// ****************************************************************

//1. The user should be able to sign into the app through facebook by pressing a button
//Document resource: https://developers.facebook.com/docs/facebook-login/android
//Place this code in XML layout:
<com.facebook.login.widget.LoginButton
    android:id="@+id/login_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center_horizontal"
    android:layout_marginTop="30dp"
    android:layout_marginBottom="30dp" />

 //Place this in the mainActivity page:
 @Override
public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.splash, container, false);

    loginButton = (LoginButton) view.findViewById(R.id.login_button);
    loginButton.setReadPermissions("user_friends");
    // If using in a fragment
    loginButton.setFragment(this);    
    // Other app specific specialization

    // Callback registration
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
        }

        @Override
        public void onCancel() {
            // App code
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
        }
    });    
}

public class MainActivity extends FragmentActivity {
    CallbackManager callbackManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.usersettings_fragment_login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { ... });

        /**************************************************************************************
         * Jason Flinn (jcf70) code begin
         *************************************************************************************/

        //Implement 4 tabs on main activity
        //Lost Tab
        //a list view / recycle view of user submitted "lost items"
        //Found Tab
        //a list view / recycle view of user submitted "found items"
        //Messaging Tab
        //messaging tab for communication between users (not sure what tech or view to use yet)
        //Profile Tab
        //user information
        //allow editing of private and public info
        //log in / out of account

        /**************************************************************************************
         * Jason Flinn (jcf70) code end
         *************************************************************************************/

    }

 //Register this callback with the login button:
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FacebookSdk.sdkInitialize(this.getApplicationContext());

    callbackManager = CallbackManager.Factory.create();

    LoginManager.getInstance().registerCallback(callbackManager,
            new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                }

                @Override
                public void onCancel() {
                     // App code
                }

                @Override
                public void onError(FacebookException exception) {
                     // App code   
                }
    });
}

//There is more code to get anroid tokens and register with facebook and google APIs
//But I will save that for later and put it in the actual app.
// ****************************************************************
// Tony Lam (t_l102) code End
// ****************************************************************

/* Clicking on a Posting
	< User first sees a list of postings (whether lost or found)
	< once clicking on one, it directs to a different screen displaying the info
	< Info Displayed: Details of item, pictures (if any), and option to contact OP
	< clicking on the contact option opens a messaging window that automatically Subjects the message as the title of posting
	< cursor is automatically blinking in the box where the message is to be typed
	< send button is visible to complete the task with a pop up message confirming message has been sent
	< User is then directed back to the original post
	
*/

/****************************************
    Adriana Rios (amr225) code begin
****************************************/
// Detect if FB log in denied
// To detect declined permissions, 
// you can call the permissions edge on the User object of the Graph API. 
// You can collect any declined permissions by iterating through the response:
FB.api('/me/permissions', function(response) {
  var declined = [];
  for (i = 0; i < response.data.length; i++) { 
    if (response.data[i].status == 'declined') {
      declined.push(response.data[i].permission)
    }
  }
  alert(declined.toString())
});

/****************************************
    Adriana Rios (amr225) code end
****************************************/

/***************************************
Woodrow Bogucki (w_b34) comment begin

I missed the memo and started working on something unrelated

This will be the design description for a lost item the user wishes to upload.

Each team member will add a feature with an explanation of how this feature satisfies the single user 
principle and possibly some pseudocode on the features execution. (not all of us are on the same page 
in android studio that should be covered in our first sprint)
The reason for two classes (one for lost and one for found) is because we may later need to change one, 
but not the other. Perhaps we should have a parent class (item) and children (lost item and found item)

Feature 1: The item description. While the item description will in fact by used by multiple users (the 
person who lost it and then later by the finding person as they attempt to match the item to its owner). 
In this section of code we shall only worry ourselves with the uploading of the item description.
In this case I theorize the item description could be held in a .txt file which would be passed as a string 
to the lost_object constructor. 

lost_object object5(description5.txt, other parameters. . .)

end comment

****************************************************/