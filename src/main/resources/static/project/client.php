<html>
<head>
    <title> OpenTok Getting Started </title>
    <link href="css/app.css" rel="stylesheet" type="text/css">
    <script src="https://static.opentok.com/v2/js/opentok.min.js"></script>
    <script src="http://localhost/project/js/button.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<bodyl>

</div> 
    <div id="videos">
        <div id="subscriber"></div>
        <div id="publisher"></div>
    </div>


<?php
	//requirements

	require "vendor/autoload.php";
        use OpenTok\OpenTok;
	use OpenTok\MediaMode;
        $apiKey = 46241052;
        $apiSecret = 'c6a5b704af4298c77c5ce08f1dd9818e829f2643';

        //connect to database
	
	$servername = "localhost";
        $username = "root";
        $password = "papayaland";
        $dbname = "tokbox";
	$conn = mysqli_connect($servername, $username, $password, $dbname);

        if(!$conn)
	{
		die("Connection failed: " . mysqli_connect_error());
	}
	$sql = "SELECT session_id FROM sessions";
	$result = mysqli_query($conn, $sql);

	$stack = array();

	if(mysqli_num_rows($result) > 0)
	{
		while($row = mysqli_fetch_assoc($result))
		{
			$sessionId = $row["session_id"];
			array_push($stack, $sessionId);
		}
	} else
	{
		echo "0 results";
	}
	
//	echo $sessionId;
	mysqli_close($conn);
	
	//generate the token
	$opentok = new OpenTok($apiKey, $apiSecret);
	$token = $opentok->generateToken($sessionId);
?>

	<script>
		var apiKey = "<?php echo $apiKey ?>";
		var sessionId = "<?php echo $sessionId ?>";
		var sessionIds = <?php echo json_encode($stack); ?>;
		var token = "<?php echo $token ?>";

		function handleError(error)
		{
			if (error)
			{
				alert(error.message);
			
			}
		}
		//initializeSession();
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
		function setSessionId1()
		{
			sessionId = sessionIds[0];
			alert(sessionId);
			initializeSession();
		}
		function setSessionId2()
		{
			sessionId = sessionIds[1];
			alert(sessionId);
			initializeSession();
		}
		function setSessionId3()
		{
			sessionId = sessionIds[2];
			alert(sessionId);
			initializeSession();
		}
	</script>
<p>							</p>
 <div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="dropdown-content">
    <a href="#" onclick="return setSessionId1();">Link 1</a>
    <a href="#" onclick="return setSessionId2();">Link 2</a>
    <a href="#" onclick="return setSessionId3();">Link 3</a>
  </div>

</body>
</html>

