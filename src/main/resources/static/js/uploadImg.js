var firebaseConfig = {
        apiKey: "AIzaSyDw1aZqYvp4SuXT4K0g2TwGDAcoXqhRcFE",
        authDomain: "spiritual-verve-292609.firebaseapp.com",
        projectId: "spiritual-verve-292609",
        storageBucket: "spiritual-verve-292609.appspot.com",
        messagingSenderId: "744237534688",
        appId: "1:744237534688:web:a767cfefe03f5994106f85",
        measurementId: "G-CVSKKM69VJ",
      };
      // Initialize Firebase
      firebase.initializeApp(firebaseConfig);

      var ImgName;
      var files = [];
      var reader;
      var metadata = {
        contentType: "image/jpeg",
      };
function selectImg(e) {
        var input = document.createElement("input");
        input.type = "file";

        input.onchange = (e) => {
          files = e.target.files;
          reader = new FileReader();
          reader.onload = () => {
            document.getElementById("myImg").src = reader.result;
          };
          reader.readAsDataURL(input.files[0]);
        };
        input.click();
      };

      document.getElementById("upload").onclick = function uploadHandleError() {
        const storageRef = firebase.storage().ref();
        var file = files[0];
        // [START storage_upload_handle_error]
        // Create the file metadata
        var metadata = {
          contentType: "image/jpeg",
        };
        // Upload ảnh avatar và đặt tên file trên cloud bằng tên user 
        var uploadTask = storageRef
          .child("images/" + document.getElementById("name").value + ".jpg")
          .put(file, metadata);

        // Listen for state changes, errors, and completion of the upload.
        uploadTask.on(
          firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
          (snapshot) => {
            // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
            var progress =
              (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            document.getElementById("upProgress").innerText =
              "Upload is " + progress.toFixed(2) + "% done";
            switch (snapshot.state) {
              case firebase.storage.TaskState.PAUSED: // or 'paused'
                console.log("Upload is paused");
                break;
              case firebase.storage.TaskState.RUNNING: // or 'running'
                console.log("Upload is running");
                break;
            }
          },
          (error) => {
            // A full list of error codes is available at
            // https://firebase.google.com/docs/storage/web/handle-errors
            switch (error.code) {
              case "storage/unauthorized":
                // User doesn't have permission to access the object
                break;
              case "storage/canceled":
                // User canceled the upload
                break;

              // ...

              case "storage/unknown":
                // Unknown error occurred, inspect error.serverResponse
                break;
            }
          },
          () => {
            // Upload completed successfully, now we can get the download URL
            uploadTask.snapshot.ref.getDownloadURL().then((downloadURL) => {
              document.getElementById("url").value = downloadURL;
            });
          }
        );
      };