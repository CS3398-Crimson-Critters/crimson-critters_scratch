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