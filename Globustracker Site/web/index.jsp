

<%
    String paymentStatus = request.getParameter("payment_status");
    System.out.println(paymentStatus+" = payment status");
    if (paymentStatus != null) {
        if (paymentStatus.equals("Completed")) {
            String itemName = request.getParameter("item_name");
            String itemNumber = request.getParameter("item_number");
            String paymentAmount = request.getParameter("mc_gross");
            String paymentCurrency = request.getParameter("mc_currency");
            String txnId = request.getParameter("txn_id");
            String receiverEmail = request.getParameter("receiver_email");
            String payerEmail = request.getParameter("payer_email");
            String custom = request.getParameter("custom");

            /////////////////////////////////////////////////////////////////////////////// Display to console
            System.out.println(itemName + " =itemName");
            System.out.println(paymentStatus + " =paymentStatus");
            System.out.println(itemNumber + " =itemNumber");
            System.out.println(paymentAmount + " =paymentAmount");
            System.out.println(paymentCurrency + " =paymentCurrency");
            System.out.println(txnId + " =txnId");
            System.out.println(receiverEmail + " =receiverEmail");
            System.out.println(payerEmail + " =payerEmail");
            System.out.println(custom + " =customerId");
            /////////////////////////////////////////////////////////////////////////////   Display to console end


            int customerID = 0;
            float amount = 0;
            try {
                customerID = Integer.parseInt(custom);
                amount = Float.parseFloat(paymentAmount);
            } catch (Exception e) {
                e.printStackTrace();
            }
            java.sql.Connection con = null;
            String url = "jdbc:mysql://localhost:3306/";
//            String url = "jdbc:mysql://localhost:3306/";
            String db = "databasename";
            String driver = "com.mysql.jdbc.Driver";
            java.sql.PreparedStatement pst = null;
            int planId = 0, camp = 0, key = 0, usr = 0;
            try {
                Class.forName(driver);
             
                con = java.sql.DriverManager.getConnection(url + db, "username", "password");
                ////////////////////////////////// txn 0th

                try {
                    pst = con.prepareStatement("select PlanID,Campaigns,Keywords,Users from plans where Name like(?)");

                    pst.setString(1, itemName);

                    java.sql.ResultSet rs1 = pst.executeQuery();
                    while (rs1.next()) {
                        planId = rs1.getInt("PlanID");
                        camp = rs1.getInt("Campaigns");
                        key = rs1.getInt("Keywords");
                        usr = rs1.getInt("Users");
                    }

                    System.out.println("1 row Selected= inserted into payments");
                    System.out.println(planId + camp + key + usr);
                } catch (java.sql.SQLException s) {
                    System.err.println(s);
                    System.out.println("SQL statement 1 is not executed!");
                }
                //////////////////////////////// txn 1st update Payments

                try {
                    pst = con.prepareStatement("INSERT into payments(CustomerID,Plan,Amount,PayerID,EbayTransactionID,PlanID) VALUES(?,?,?,?,?,?)");
                    pst.setInt(1, customerID);
                    pst.setString(2, itemName);
                    pst.setFloat(3, amount);
                    pst.setString(4, payerEmail);
                    pst.setString(5, txnId);
                    pst.setInt(6, planId);

                    int val = pst.executeUpdate();
                    System.out.println("1 row affected= inserted into payments");
                } catch (java.sql.SQLException s) {
                    System.err.println(s);
                    System.out.println("SQL statement 1 is not executed!");
                }
                /////////////////////////////// txn 2nd update customers
                try {
                    pst = con.prepareStatement("update customers set AllowedUserCount=?,AllowedKeywordCount=?,AllowedCampaignsCount=? where CustomerID=?");

                    pst.setInt(1, usr);
                    pst.setInt(2, key);
                    pst.setInt(3, camp);
                    pst.setInt(4, customerID);

                    pst.executeUpdate();

                } catch (java.sql.SQLException s) {
                    System.err.println(s);
                    System.out.println("SQL statement 2 is not executed!");
                }
                ///////////////////////////////////////////////////////////
            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
            } finally {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst = null;
                }
                System.gc();

            }

        }
    }


    response.sendRedirect("home.action");%>

<%-- response.sendRedirect("sitesList.action"); --%>
