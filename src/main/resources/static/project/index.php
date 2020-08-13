<html>
<head>
    <title> OpenTok Getting Started </title>
    <link href="css/app.css" rel="stylesheet" type="text/css">
    <script src="https://static.opentok.com/v2/js/opentok.min.js"></script>
</head>
<body>

    <div id="videos">
        <div id="subscriber"></div>
        <div id="publisher"></div>
    </div>


<?php
        require "vendor/autoload.php";
        use OpenTok\OpenTok;
        use OpenTok\MediaMode;
        $apiKey = 46241052;
        $apiSecret = 'c6a5b704af4298c77c5ce08f1dd9818e829f2643';
        $opentok = new OpenTok($apiKey, $apiSecret);
        $session = $opentok->createSession(array( 'mediaMode' => MediaMode::ROUTED ));
        $sessionId = $session->getSessionId();
     
	echo $sessionId;
      	 $token = $opentok->generateToken($sessionId);
	
	//connect to database
	$servername = "localhost";
	$username = "root";
	$password = "papayaland";
	$dbname = "tokbox";

	//create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	//check connection
	if ($conn->connect_error){
		die("Connection failed: " . $conn->connect_error);
	}
		$sql = "INSERT INTO sessions(session_id)
		VALUES('$sessionId')";	
		if($conn->query($sql) === TRUE){
		echo "New record created successfully";
	} else{
		echo "Error: " . $sql . "<br>" . $conn->error;
	}
	$conn->close();
?>
    
	<script>
                var apiKey = "<?php echo $apiKey ?>";
                var sessionId = "<?php echo $sessionId ?>";
                var token = "<?php echo $token ?>";
                
                function handleError(error)
                {
                        if (error)
                        {
                                alert(error.message);
                        
                        }
                }
                initializeSession();
                function initializeSession()
                {
                        var session = OT.initSession(apiKey, sessionId);
                        session.on('streamCreated', function(event)
                        {
                                session.subscribe(event.stream, 'subscriber',
                                {
                                        insertMode: 'append',
                                        width: '100%',
                                        height: '100%'
                                }, handleError);
                        });
                        var publisher = OT.initPublisher('publisher',
                        {
                                insertMode: 'append',
                                        width: '100%',
                                        height: '100%'
                        }, handleError);
                        session.connect(token, function(error)
                        {
                                if (error)
                                {
                                        handleError(error);
                                } else
                                {
                                        session.publish(publisher, handleError);
                                }
                        });
                }
        </script>

</body>
</html>

