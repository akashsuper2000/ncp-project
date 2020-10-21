<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<table width="250px" style="margin:0 auto;text-align:center"
				border="1">
				
				<tr>
					<th>Userid</th>
					<th>PaymentRefNo</th>
					<th>Amount</th>
					<th>Donated_date</th>
					<th>Pan_number</th>
				</tr>

				<xsl:for-each select="/payments/payment">

					<tr>
						<td>
							<xsl:value-of select="userid" />
						</td>
						<td>
							<xsl:value-of select="paymentRefNo" />
						</td>
						<td>
							<xsl:value-of select="amount" />
						</td>
						<td>
							<xsl:value-of select="donated_date" />
						</td>
						<td>
							<xsl:value-of select="pan_number" />
						</td>
					</tr>
				</xsl:for-each>
			</table>
			<br></br>
			<br></br>	
			<table width="250px" style="margin:0 auto;text-align:center"
				border="1">
				<tr>
					<th colspan='5'>Recent Donations (less than 3 months)</th>
				</tr>
				
				<tr>
					<th>Userid</th>
					<th>PaymentRefNo</th>
					<th>Amount</th>
					<th>Donated_date</th>
					<th>Pan_number</th>
				</tr>
				
				<xsl:for-each select="/payments/payment">
					<xsl:variable name="comp_date" select="translate(donated_date, '- ', '')" />

					<xsl:if test="$comp_date &gt;= 20200722">
						<tr>
							<td>
								<xsl:value-of select="userid" />
							</td>
							<td>
								<xsl:value-of select="paymentRefNo" />
							</td>
							<td>
								<xsl:value-of select="amount" />
							</td>
							<td>
								<xsl:value-of select="donated_date" />
							</td>
							<td>
								<xsl:value-of select="pan_number" />
							</td>
						</tr>
					</xsl:if>
				</xsl:for-each>
				
			</table>



		</html>

	</xsl:template>

</xsl:stylesheet>
